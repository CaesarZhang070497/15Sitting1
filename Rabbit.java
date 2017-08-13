import java.util.Arrays;
import java.util.Collections;

public class Rabbit {
	Integer[][] r;
	int n;
	
	public Rabbit(int n) {
		this.n = n;
		r = new Integer[n][];
	}
	
	public void init(){
		if(n<2){
			return;
		}
		
		r[0] = new Integer[]{1};
		r[1] = new Integer[]{1,0};
		
		for(int n = 2;n<r.length;n++){
			r[n] = new Integer[r[n-1].length+r[n-2].length];
			
			for(int i = 0;i<r[n-1].length;i++){
				r[n][i] = r[n-1][i];
			}
			
			for(int i = (r[n-1].length);i<(r[n-1].length+r[n-2].length);i++){
				r[n][i] = r[n-2][i-(r[n-1].length)];
			}
		}
	}

	public String toString(){
		String output = "";
		for(int i = 0;i<r.length;i++){
			output += Arrays.toString(r[i])+"\n";
		}
		return output;
	}
	
	public  int subsequenceIndex(Integer[] arr){
		for(int i = 0;i<r.length;i++){
			if(Collections.indexOfSubList(Arrays.asList(r[i]), Arrays.asList(arr))!=-1){
				return Collections.indexOfSubList(Arrays.asList(r[i]), Arrays.asList(arr));
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		if(a>=2){
			Rabbit rabbit = new Rabbit(a);
			rabbit.init();
			System.out.print(rabbit.toString());
			System.out.println(rabbit.subsequenceIndex(new Integer[]{1,1,0})); 
			System.out.println(rabbit.subsequenceIndex(new Integer[]{1,1,1})); 
		}
	}
}
