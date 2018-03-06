package jianzhi_offer.one;

// 二维数组中的查找
public class Solution {
    public boolean Find(int [][] array,int target) {
        //m表示行，n表示列
        int m=array.length;
        int n=array[0].length;
        //i表示行，j表示列
        int i=0;
        int j=n-1;
        boolean isfound=false;
        //从右上角开始往左下角寻找target
        while(i<m&&j>=0){
            if(array[i][j]==target){
                isfound=true;
                break;
            }else if(array[i][j]<target){//array[i][j]>target，下标向下
                i++;
            }else{//array[i][j]>target，下标向左
                j--;
            }
        }
        return isfound;
    }
}
