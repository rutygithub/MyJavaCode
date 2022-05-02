import java.util.*;

public class WebCrawler {
    interface HtmlParser {
        abstract List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        //https://leetcode.com/problems/web-crawler/discuss/409952/JAVA-BFS
        //这道题目其实也就是看看,基本的graph BFS, queue+hashset, offer, poll, offer，onsite 基本面试web crawler的system design Q.
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String mainHostname = getHostname(startUrl);

        queue.offer(startUrl);
        set.add(startUrl);

        while (!queue.isEmpty()) {
            String currentUrl = queue.poll();
            for (String url : htmlParser.getUrls(currentUrl)) {
                String hns = getHostname(url);
                if (hns.equals(mainHostname) && !set.contains(url)) {
                    queue.offer(url);
                    set.add(url);
                }
            }
        }

        return new ArrayList<>(set);
    }

    private String getHostname(String Url) {
        String sub = Url.substring(7);
        //delete the start 'http://' in the string
        String[] ss = sub.split("/");
        return ss[0];
    }
}
