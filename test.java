package haha.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 王扶摇
 * @Title: test
 * @ProjectName test
 * @date 2018/8/27 16:09
 */

public class test {

    static String s = "CCwYI1Jsh58HDSn023FLj\t7618061891113196\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t6015012662598620\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t9716082774204970\t097\n" +
            "CCwYI1Jsh58HDSn023FLj\t1115111600441077\t011\n" +
            "CCwYI1Jsh58HDSn023FLj\t5116102118468693\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t2012040732574516\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t5914120427781523\t059\n" +
            "CCwYI1Jsh58HDSn023FLj\t9217021342239838\t034\n" +
            "CCwYI1Jsh58HDSn023FLj\t1113021858698507\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t1506017820\t090\n" +
            "CCwYI1Jsh58HDSn023FLj\t1817053044620642\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t3817021324286292\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118032856427327\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1718041696479900\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t1017073070529989\t090\n" +
            "CCwYI1Jsh58HDSn023FLj\t1918012265301363\t019\n" +
            "CCwYI1Jsh58HDSn023FLj\t7018062450374068\t070\n" +
            "CCwYI1Jsh58HDSn023FLj\t3117121459549333\t031\n" +
            "CCwYI1Jsh58HDSn023FLj\t5018062977619364\t050\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818061615085311\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118032355928718\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t166899106\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t9216121743769981\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t1815052932729209\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t3418011463385779\t034\n" +
            "CCwYI1Jsh58HDSn023FLj\t1900000021815545\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7718062137497707\t010\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618070976129714\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t5116082315984829\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t7117041283466090\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t3117031683313218\t031\n" +
            "CCwYI1Jsh58HDSn023FLj\t7617060751646064\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t3415111475750813\t034\n" +
            "CCwYI1Jsh58HDSn023FLj\t3616112677091687\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t1115030328665618\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7415042432805082\t074\n" +
            "CCwYI1Jsh58HDSn023FLj\t7618040244539270\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t1716080226344633\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t1116012107589339\t011\n" +
            "CCwYI1Jsh58HDSn023FLj\t8518051186737231\t085\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118030553824017\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t3816120783787606\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t3818033068848775\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t5117102227654569\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1015101100334136\t010\n" +
            "CCwYI1Jsh58HDSn023FLj\t8718052942274213\t087\n" +
            "CCwYI1Jsh58HDSn023FLj\t5117101387040051\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1117112729981064\t011\n" +
            "CCwYI1Jsh58HDSn023FLj\t191081051\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t3818040969528767\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t8917092196654844\t089\n" +
            "CCwYI1Jsh58HDSn023FLj\t2011051024215112\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618061273923456\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818072765443464\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t48483818\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t192935652\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t3017101755485981\t090\n" +
            "CCwYI1Jsh58HDSn023FLj\t2010122721376123\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t4243479528\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t1916112643000852\t019\n" +
            "CCwYI1Jsh58HDSn023FLj\t4243479543\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t1018032583011686\t010\n" +
            "CCwYI1Jsh58HDSn023FLj\t1718042213968839\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t5117102227654406\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t7118010553739901\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t9717122160030480\t097\n" +
            "CCwYI1Jsh58HDSn023FLj\t3018060174760721\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t7118060314316479\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t3817071998237605\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t8718032867818360\t087\n" +
            "CCwYI1Jsh58HDSn023FLj\t5917070669659120\t059\n" +
            "CCwYI1Jsh58HDSn023FLj\t2013081050664919\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t7518053162607274\t075\n" +
            "CCwYI1Jsh58HDSn023FLj\t1817051085157934\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t8618071677027289\t086\n" +
            "CCwYI1Jsh58HDSn023FLj\t9118050747629887\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t7117081692280693\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t3018032617733308\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t3816112783069842\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t5117102227654674\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818061462797146\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t4243479604\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t736047468\t075\n" +
            "CCwYI1Jsh58HDSn023FLj\t2017091333195961\t013\n" +
            "CCwYI1Jsh58HDSn023FLj\t7117080491420777\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t1118062734813771\t011\n" +
            "CCwYI1Jsh58HDSn023FLj\t7118072117508483\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t8717010378999822\t087\n" +
            "CCwYI1Jsh58HDSn023FLj\t3818060373359738\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t1917041988227456\t019\n" +
            "CCwYI1Jsh58HDSn023FLj\t3817080350009086\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118060463517869\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1018032583012010\t010\n" +
            "CCwYI1Jsh58HDSn023FLj\t9118050747629649\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t7418072165538735\t074\n" +
            "CCwYI1Jsh58HDSn023FLj\t1117052694024608\t011\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618051171139699\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t9018062622918984\t090\n" +
            "CCwYI1Jsh58HDSn023FLj\t7616012016875666\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818072765443912\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t7518011154949619\t075\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618032066880878\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818011154150857\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t8714110526487877\t087\n" +
            "CCwYI1Jsh58HDSn023FLj\t1018032583010852\t010\n" +
            "CCwYI1Jsh58HDSn023FLj\t193610853\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t4143448925\t059\n" +
            "CCwYI1Jsh58HDSn023FLj\t8917032233728432\t089\n" +
            "CCwYI1Jsh58HDSn023FLj\t1109120910176770\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7118040559411581\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t736063182\t075\n" +
            "CCwYI1Jsh58HDSn023FLj\t3418062574910895\t034\n" +
            "CCwYI1Jsh58HDSn023FLj\t1717072849632838\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t3015051368779094\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t7618032082596112\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t7115082840071441\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7118070964282499\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t1718040813237407\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t5116110283730480\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t9118050747629829\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t1718042213969500\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t8718062875184176\t087\n" +
            "CCwYI1Jsh58HDSn023FLj\t1504391140\t090\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118042332138021\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t191121844\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t7117122753167145\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7614053124261732\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t3417050392463932\t034\n" +
            "CCwYI1Jsh58HDSn023FLj\t9118020105427761\t085\n" +
            "CCwYI1Jsh58HDSn023FLj\t1818070116282722\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618060473187497\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t5617020786951843\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t8115020630499182\t081\n" +
            "CCwYI1Jsh58HDSn023FLj\t5117091583934906\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t8417102856906471\t084\n" +
            "CCwYI1Jsh58HDSn023FLj\t2017072490060305\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1717030542988350\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t8015121161071773\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t179814210\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t176464235\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t3018032617733307\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t3817051192956993\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t1811050413020278\t071\n" +
            "CCwYI1Jsh58HDSn023FLj\t7016110574886973\t070\n" +
            "CCwYI1Jsh58HDSn023FLj\t8617092954929219\t086\n" +
            "CCwYI1Jsh58HDSn023FLj\t1917092071419365\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t4242949469\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t197210344\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t1716072825557297\t017\n" +
            "CCwYI1Jsh58HDSn023FLj\t5118011898713151\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t9117122553913414\t091\n" +
            "CCwYI1Jsh58HDSn023FLj\t3618042770073725\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t547802182\t074\n" +
            "CCwYI1Jsh58HDSn023FLj\t4243479581\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t3018032170025284\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t7617111370321333\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t3114081524779796\t031\n" +
            "CCwYI1Jsh58HDSn023FLj\t3817050392425193\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t7418022558019738\t074\n" +
            "CCwYI1Jsh58HDSn023FLj\t7615111405304306\t076\n" +
            "CCwYI1Jsh58HDSn023FLj\t3014120567308125\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t3118061774235207\t031\n" +
            "CCwYI1Jsh58HDSn023FLj\t3617112858085649\t036\n" +
            "CCwYI1Jsh58HDSn023FLj\t3818051233348412\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t1815030529176674\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t159286460\t038\n" +
            "CCwYI1Jsh58HDSn023FLj\t160706054512607\t097\n" +
            "CCwYI1Jsh58HDSn023FLj\t5617020786951842\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t4237455925\t083\n" +
            "CCwYI1Jsh58HDSn023FLj\t6917112570225579\t051\n" +
            "CCwYI1Jsh58HDSn023FLj\t1817040942055406\t018\n" +
            "CCwYI1Jsh58HDSn023FLj\t610023654246\t030\n" +
            "CCwYI1Jsh58HDSn023FLj\t193224269\t038";


    static String Stringurl = "http://192.168.1.1/jzyxpt/callout" +
            "/getDataDetail?activityId=%s&provideId=%s&custormerId=%s";

    public static void main(String[] args) {
        List<String> activityId = new ArrayList<>();
        List<String> custormerid = new ArrayList<>();
        List<String> provideId = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        List<aa> relist = new ArrayList<>(173);
        StringBuilder stringBuilder = new StringBuilder();
        aa a = null;
        int flag = 0;
        while (stringTokenizer.hasMoreTokens()) {
            if (flag == 3)
                flag = 0;
            switch (flag) {
                case 0:
                    activityId.add(stringTokenizer.nextToken());
                    break;
                case 1:
                    custormerid.add(stringTokenizer.nextToken());
                    break;
                case 2:
                    provideId.add(stringTokenizer.nextToken());
                    break;
            }
            flag++;
        }

        try {

            for (int i = 0; i < 1; i++) {
                String realurl = String.format(Stringurl, activityId.get(i), provideId.get(i), custormerid.get(i));
                URL url = new URL(realurl);
                System.out.println(realurl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.connect();
                String line = "";
                if (connection.getResponseCode() == 200) {

                    try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {

                        while ((line = inputStream.readLine()) != null) {
                            stringBuilder.append(line);
                            JSONObject jsonObject = JSON.parseObject(stringBuilder.toString());
                            JSONArray jsonArray = jsonObject.getJSONArray("resultList");
                            a = (haha.test.aa) jsonArray.getObject(0, aa.class);
                            relist.add(a);

                        }

                    }
                }
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
