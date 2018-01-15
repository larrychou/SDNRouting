package findKthShortPath;
import Bean.Node;
import Bean.Link;

import java.util.*;

/**
 *
 */
public class Operation {
    public static int generation = 100;
    public static int populationSize = 100;

    public static void main(String[] args) {
        String path = "config\\test.txt";
        NodesAndLinks.readFile(path);
        Map<Integer,TreeSet<Integer>> nextHop = calcNextHopList(NodesAndLinks.linkArr);

        //生成了种群
        ArrayList<int[]> chromosomeList = calcChromosomeList(NodesAndLinks.nodeList);

        int start = 18;
        int end = 7;
        ArrayList population = new ArrayList();
        //解码
        while(population.size()<populationSize){
            ArrayList<Integer> result = decodeChromosome(start,end,nextHop,chromosomeList.get(i));
            
            population.add(result);
            System.out.println(result);
        }
        System.out.println("nice!!!!");
    }

    //解码染色体
    public static ArrayList<Integer> decodeChromosome(int start,int end,Map<Integer,TreeSet<Integer>> nextHop,int[] chromosome){
        ArrayList<Integer> pathArr = new ArrayList <Integer>();
        int index = start;
        int flag = -1;//记录优先级值
        pathArr.add(start);
        while(index !=end){
            TreeMap<Integer,Integer> mapCode = new TreeMap <Integer, Integer>();//节点值与优先级值映射
            TreeSet<Integer> setNextHop = nextHop.get(index);
            Iterator<Integer> iter = setNextHop.iterator();
            while(iter.hasNext()) {
                int tt = iter.next();
                mapCode.put(chromosome[tt],tt);
            }

            while(flag !=-1 && !mapCode.isEmpty() && mapCode.lastKey()>=flag){
                mapCode.remove(mapCode.lastKey());
            }
            while(!mapCode.isEmpty()) {
                int pp = -1;
                pp = mapCode.get(mapCode.lastKey());
                if(!pathArr.contains(pp)) {//防止环路
                    pathArr.add(pp);
                    index = pp;
                    flag = -1;
                    break;//跳出循环
                }else{//集合中包含该节点，即出现环路
                    mapCode.remove(mapCode.lastKey());
                }
            }
            if(mapCode.isEmpty() && index!=start){//如果该节点走不通，回退上一节点
                pathArr.remove(pathArr.size()-1);
                flag = chromosome[index];
                index = pathArr.get(pathArr.size()-1);
            }else if(mapCode.isEmpty() && index == start){//如果该节点走不通，并且该节点是首节点，则该路不通，
                pathArr.clear();
                pathArr.add(-1);
            }
        }
        return pathArr;
    }

    //统计每一个节点的相连的下一跳节点的集合
    public static Map<Integer,TreeSet<Integer>> calcNextHopList(Link[][] linkArr){
        Map<Integer,TreeSet<Integer>> nextHop = new HashMap<Integer,TreeSet<Integer>>();
        for(int i = 0; i<NodesAndLinks.nodeList.size();i++){
            TreeSet<Integer> set = new TreeSet <Integer>();
            for(int j=0;j<NodesAndLinks.nodeList.size();j++){
                if(NodesAndLinks.linkArr[i][j]!=null){
                    set.add(NodesAndLinks.linkArr[i][j].getN_index2());
                }
                if(NodesAndLinks.linkArr[j][i]!=null){
                    set.add(NodesAndLinks.linkArr[j][i].getN_index1());
                }
            }
            nextHop.put(i,set);
        }
        return nextHop;
    }
    //生成种群
    public static ArrayList<int[]> calcChromosomeList(ArrayList<Node> nodeList){
        ArrayList<int[]> list = new ArrayList <int[]>();
        for(int i=0;i<populationSize ; i++){
            list.add(encodingChromosome(nodeList));
        }
        return list;
    }

    //编码染色体
    public static int[] encodingChromosome(ArrayList<Node> nodeList) {
        int size = nodeList.size();
        int[] nodeArr = new int[size];
        for(int i=0;i<nodeArr.length;i++){
            nodeArr[i] = i;
        }
        for (int i=0;i<generation; i++){
            Random r = new Random();
            int left = r.nextInt(size);
            int right = r.nextInt(size);
            int temp = nodeArr[left];
            nodeArr[left] = nodeArr[right];
            nodeArr[right] = temp;
        }
        return nodeArr;
    }
}
