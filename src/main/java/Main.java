import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static Link[][] linkArr = new Link[100][100];
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static void main(String[] args) {
        String path = "C:/test.txt";
        readFile(path);
    }
    public static void readFile(String path){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("路径错误！");
            e.printStackTrace();
        }
        String str ="";
        int nodeNum=0;
        int linkNum = 0;

        try {
            while((str=br.readLine())!=null){
                if(!str.startsWith("#")){
                    String[] strArr = str.split(" ");
                    if(strArr.length==2 && strArr[0].equals("t1")){
                        nodeNum=Integer.valueOf(strArr[1]);
                    }
                    else if(strArr.length==2 && strArr[0].equals("T2")){
                        linkNum=Integer.valueOf(strArr[1]);
                    }
                    else if(strArr[0].equals("n")){
                        Node node = new Node(Integer.valueOf(strArr[1]),strArr[2],Integer.valueOf(strArr[3]),
                                Integer.valueOf(strArr[4]),Integer.valueOf(strArr[5]));
                        nodeList.add(node);
                    }else if(strArr[0].equals("l")){
                        Link temp = new Link(Integer.valueOf(strArr[1]),Integer.valueOf(strArr[2]),
                                Integer.valueOf(strArr[3]),Integer.valueOf(strArr[4]),
                                Integer.valueOf(strArr[5]),Integer.valueOf(strArr[6]));
                        linkArr[Integer.valueOf(strArr[2])][Integer.valueOf(strArr[3])]=temp;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("读取文件错误！！");
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("文件关闭错误");
            e.printStackTrace();
        }
    }
}
