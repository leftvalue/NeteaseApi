import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author linxi
 * www.leftvalue.top
 * PACKAGE_NAME
 * Date 2018/6/28 1:09 AM
 */
public class OK {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("json.txt")));
        JSONObject root = JSONObject.parseObject(content);
        JSONObject playlist = root.getJSONObject("playlist");
        String creater_name = playlist.getJSONObject("creator").getString("nickname");
        System.out.println(creater_name);
        String userId = playlist.getJSONObject("creator").getString("userId");
        System.out.println(userId);
        JSONArray tracks = playlist.getJSONArray("tracks");
        for (Object track_ : tracks) {
            // convert to  jsonobject
            JSONObject track = JSONObject.parseObject(track_.toString());
            String song_name = track.getString("name");
            String song_id = track.getString("id");
            System.out.println(song_name + " " + song_id);
        }
    }
}
