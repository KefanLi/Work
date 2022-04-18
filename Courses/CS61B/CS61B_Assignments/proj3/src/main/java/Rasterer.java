import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {

    private static final double LONDPP = 0.00034332275390625;

    private class QueryBox {
        private double ullon, ullat, lrlon, lrlat;
        private double w, h;

        QueryBox(double ullon, double ullat, double lrlon, double lrlat,
                        double w, double h) {
            this.ullon = ullon;
            this.ullat = ullat;
            this.lrlon = lrlon;
            this.lrlat = lrlat;
            this.w = w;
            this.h = h;
        }
    }

    private class Area {
        private double ullon, ullat, lrlon, lrlat;

        Area(double ullon, double ullat, double lrlon, double lrlat) {
            this.ullon = ullon;
            this.ullat = ullat;
            this.lrlon = lrlon;
            this.lrlat = lrlat;
        }
    }

    private String[][] fileNames;
    private double rasterUllon, rasterUllat, rasterLrlon, rasterLrlat;
    private int ulx, uly, lrx, lry;
    private int depth;

    public Rasterer() {
        // YOUR CODE HERE
    }

    private void setDepth(QueryBox qb) {
        double dpp = (qb.lrlon - qb.ullon) / qb.w;
        for (int i = 0; i <= 7; i++) {
            if (calDepthDpp(i) <= dpp) {
                this.depth = i;
                return;
            }
        }
        this.depth = 7;
    }

    private double calDepthDpp(int dep) {
        return LONDPP / pow2(dep);
    }

    private int pow2(int n) {
        int res = 1;
        while (n-- > 0) {
            res = res * 2;
        }
        return res;
    }

    private void solve(QueryBox qb) {
        setDepth(qb);
        boolean findUl = false;
        boolean findLr = false;
        for (int i = 0; i < pow2(depth); i++) {
            for (int j = 0; j < pow2(depth); j++) {
                Area area = getArea(depth, i, j);
                if (area.lrlon > qb.ullon && area.lrlat < qb.ullat) {
                    this.rasterUllon = area.ullon;
                    this.rasterUllat = area.ullat;
                    this.ulx = i;
                    this.uly = j;
                    findUl = true;
                    break;
                }
            }
            if (findUl) {
                break;
            }
        }

        for (int i = pow2(depth) - 1; i >= 0; i--) {
            for (int j = pow2(depth) - 1; j >= 0; j--) {
                Area area = getArea(depth, i, j);
                if (area.ullon < qb.lrlon && area.ullat > qb.lrlat) {
                    this.rasterLrlon = area.lrlon;
                    this.rasterLrlat = area.lrlat;
                    this.lrx = i;
                    this.lry = j;
                    findLr = true;
                    break;
                }
            }
            if (findLr) {
                break;
            }
        }
        getFileNames();
    }

    private void getFileNames() {
        fileNames = new String[lry - uly + 1][lrx - ulx + 1];
        for (int i = 0; i <= lry - uly; i++) {
            for (int j = 0; j <= lrx - ulx; j++) {
                fileNames[i][j] = "d" + depth + "_x" + (ulx + j)
                        + "_y" + (uly + i) + ".png";
            }
        }
    }

    private Area getArea(int dep, int x, int y) {
        double lonDelta = (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / pow2(dep);
        double latDelta = (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / pow2(dep);
        double ullon = MapServer.ROOT_ULLON + lonDelta * x;
        double ullat = MapServer.ROOT_ULLAT - latDelta * y;
        double lrlon = ullon + lonDelta;
        double lrlat = ullat - latDelta;
        return new Area(ullon, ullat, lrlon, lrlat);
    }


    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     * <p>
     * The grid of images must obey the following properties, where image in the
     * grid is referred to as a "tile".
     * <ul>
     *     <li>The tiles collected must cover the most longitudinal distance per pixel
     *     (LonDPP) possible, while still covering less than or equal to the amount of
     *     longitudinal distance per pixel in the query box for the user viewport size. </li>
     *     <li>Contains all tiles that intersect the query bounding box that fulfill the
     *     above condition.</li>
     *     <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     * </ul>
     *
     * @param params Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     * @return A map of results for the front end as specified: <br>
     * "render_grid"   : String[][], the files to display. <br>
     * "raster_ul_lon" : Number, the bounding upper left longitude of the rastered image. <br>
     * "raster_ul_lat" : Number, the bounding upper left latitude of the rastered image. <br>
     * "raster_lr_lon" : Number, the bounding lower right longitude of the rastered image. <br>
     * "raster_lr_lat" : Number, the bounding lower right latitude of the rastered image. <br>
     * "depth"         : Number, the depth of the nodes of the rastered image <br>
     * "query_success" : Boolean, whether the query was able to successfully complete; don't
     * forget to set this to true on success! <br>
     */
    public Map<String, Object> getMapRaster(Map<String, Double> params) {
        System.out.println(params);
        Map<String, Object> results = new HashMap<>();
        double ullat = params.get("ullat");
        double ullon = params.get("ullon");
        double lrlat = params.get("lrlat");
        double lrlon = params.get("lrlon");
        double w = params.get("w");
        double h = params.get("h");
        if (lrlon < MapServer.ROOT_ULLON && lrlat > MapServer.ROOT_ULLAT
                && ullon > MapServer.ROOT_LRLON && ullat < MapServer.ROOT_LRLAT) {
            results.put("query_success", false);
            return results;
        }
        if (ullon > lrlon && ullat < lrlat) {
            results.put("query_success", false);
            return results;
        }
        QueryBox queryBox = new QueryBox(ullon, ullat, lrlon, lrlat, w, h);
        solve(queryBox);
        results.put("render_grid", fileNames);
        results.put("raster_ul_lon", rasterUllon);
        results.put("raster_ul_lat", rasterUllat);
        results.put("raster_lr_lon", rasterLrlon);
        results.put("raster_lr_lat", rasterLrlat);
        results.put("depth", depth);
        results.put("query_success", true);
        System.out.println(results);
        return results;
    }
}
