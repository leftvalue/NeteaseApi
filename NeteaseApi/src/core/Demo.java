package core;

import netease.Api;
import netease.UrlParamPair;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import secret.JSSecret;

public class Demo {
    public static void main(String[] args) {
        try {
            comments();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 评论测试
     *
     * @throws Exception
     */
    static void comments() throws Exception {
        String song_id = "28754105";
        UrlParamPair upp = Api.getComments(song_id, 2);
        String req_str = upp.getParas().toJSONString();
        Connection.Response response = Jsoup.connect("https://music.163.com/weapi/v1/resource/comments/R_SO_4_28754105?csrf_token=")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0 Safari/605.1.15")
                .referrer("https://music.163.com/song?id=28754105")
                .cookie("WM_NI", "DXy%2BepbQMcN%2F8Hy9c69mXrQtZbCeL%2Blhp1bLFZopGiOPK3FYjQC1r1kgbC29nmelEuOgO%2BZL5mjW5dHiwCqmyWrqEnC%2FErFUBeXlOIVpNw0f0rbda%2FEONuphupwaQnzHUkI%3D")
                .cookie("mp_MA-9ADA-91BF1A6C9E06_hubble", "%7B%22sessionReferrer%22%3A%20%22https%3A%2F%2Fcampus.163.com%2F%23%2FapplyJob%2FempRecode%22%2C%22updatedTime%22%3A%201535001723535%2C%22sessionStartTime%22%3A%201535001723527%2C%22sendNumClass%22%3A%20%7B%22allNum%22%3A%202%2C%22errSendNum%22%3A%200%7D%2C%22deviceUdid%22%3A%20%2240543125-1507-4cf0-b811-7e921def0642%22%2C%22persistedTime%22%3A%201535001723523%2C%22LASTEVENT%22%3A%20%7B%22eventId%22%3A%20%22da_screen%22%2C%22time%22%3A%201535001723535%7D%2C%22sessionUuid%22%3A%20%22b6956469-307d-486e-a363-8b1ace26e0d9%22%7D")
                .cookie("JSESSIONID-WYYY", "ciOeAnO48IaxOieMX9Sii8sISEadn%2Ba6k2mCKfWXjhSPmsfN2yO0rRtsAbCVV0JH1VsOMb64s3RVmkeUCvuwgxtXnPdZ%2FKF%5CRuCsic27oqZ9Jl%2BJx0RjX12YIN8B%2F09QAC33eqp9v5YAFBysxqFJtzI%5CjjyF74hB879HB9rkhZr1Rvzr%3A1535790893036")
                .cookie("__utmz=94650624.1535789093.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd", "(none)")
                .cookie("_iuqxldmzr_", "32")
                .cookie("_ntes_nnid", "408c069633ebb3f8bc354519653b6255,1535789093145")
                .cookie("_ga", "GA1.2.1405325413.1534729979")
                .cookie("WM_TID", "3IXHIJ7rYCN6uWaJJX9Bz6ie7nkwuFl9")
                .cookie("__utmb", "94650624.4.10.1535789093")
                .cookie("__utmc", "94650624")
                .cookie("_ntes_nuid", "408c069633ebb3f8bc354519653b6255")
                .cookie("WM_NIKE", "9ca17ae2e6ffcda170e2e6eeb7c752b0b6f9a7c425b295fab8e93483b1bcdac25ca3eaaba2c9748eb39a91c12af0fea7c3b92a8888b7cce87ca28f8384cd25fc98b7dae23efbb39893d4809abe8d86cf21b0b8c0d2e1488686a191c6638d9085d4c553aa8f8dd2f13ba9b9aea4b133aeb3ab8dc87f8db981ccd948f7b3a6b8b8708cb7b9a4f467bb89be92c86681f18b93c55f82bb988dce4396b08298b36ef4aeae85e42587918296f364b7b0b982d466ba989b8ccc37e2a3")
                .cookie("__utma", "94650624.1405325413.1534729979.1535789093.1535789093.1")
                .header("Origin", "https://music.163.com")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .header("Host", "music.163.com")
                .header("Accept-Language", "en-us")
                .header("Accept-Encoding", "br, gzip, deflate")
                .header("DNT", "1")
                .header("Content-Length", "488")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .data(JSSecret.getDatas(req_str))
                .method(org.jsoup.Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        System.out.println(response.body());
    }

    static void gedan() throws Exception {
        String uid = "1323702956";
        UrlParamPair upp = Api.getPlaylistOfUser(uid, -1);
        String req_str = upp.getParas().toJSONString();
        Connection.Response
                response = Jsoup.connect("https://music.163.com/weapi/v1/play/record?csrf_token=")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Host", "music.163.com")
                .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                .header("DNT", "1")
                .header("Pragma", "no-cache")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .data(JSSecret.getDatas(req_str))
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String body = response.body();
        System.out.println(body);
    }
}
