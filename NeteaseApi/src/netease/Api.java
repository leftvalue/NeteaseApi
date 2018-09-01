package netease;

public class Api {
    private final static String BaseURL = "http://music.163.com/";

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static UrlParamPair getPlaylistOfUser(String uid, int i) {
        UrlParamPair upp = new UrlParamPair();
        upp.setUrl(BaseURL + "weapi/user/playlist?csrf_token=");
        upp.addPara("offset", 0);
        upp.addPara("uid", uid);
        upp.addPara("limit", 5);
        upp.addPara("csrf_token", "nothing");
        upp.addPara("type", i);
        return upp;
    }

    /**
     * 获取歌单详情
     *
     * @param playlist_id
     * @return
     */
    public static UrlParamPair getDetailOfPlaylist(String playlist_id) {
        UrlParamPair upp = new UrlParamPair();
        upp.setUrl(BaseURL + "weapi/v3/playlist/detail?csrf_token=");
        upp.addPara("id", playlist_id);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 1000);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }


    /**
     * @param songid 28754105
     * @return 评论列表
     */
    public static UrlParamPair getComments(String songid, int offset) {
        UrlParamPair upp = new UrlParamPair();
        upp.setUrl("https://music.163.com/weapi/v1/resource/comments/R_SO_4_" + songid + "?csrf_token=");
        /**
         * 'username': '',
         *    'password': '',
         *    'rememberLogin': 'true',
         *    'offset':2
         */
        upp.addPara("username", "");
        upp.addPara("password", "");
        upp.addPara("rememberLogin", "true");
        upp.addPara("offset", "" + offset);
        return upp;
    }

    //todo:analyse more api
}
