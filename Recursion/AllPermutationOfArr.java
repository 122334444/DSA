public class AllPermutationOfArr {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        permute(0,A,new ArrayList<Integer>(),list);
        return list;
    }
    
    private void permute(int idx,ArrayList<Integer>A,ArrayList<Integer>ls,ArrayList<ArrayList<Integer>>list){
        if(idx==A.size()){
            list.add(new ArrayList<>(ls));
        }
        
        for(int i=idx;i<A.size();i++){
            swap(A,idx,i);
            ls.add(A.get(idx));
            permute(idx+1,A,ls,list);
            ls.remove(ls.size()-1);
            swap(A,idx,i);
        }
    }
    
     public void swap(ArrayList<Integer>A, int x, int y){
        int temp = A.get(x);
        A.set(x,A.get(y));
        A.set(y, temp);
    }
}
