import java.util.HashMap;

public class BonusSeller extends Seller{
	
	private HashMap<String, Double> sale;

	public BonusSeller(String n) {
		super(n);
		sale = new HashMap<String, Double>();
	}
	
	public void sale(String name,double amount){
		super.sale(amount);
		if(sale.containsKey(name)){
			sale.put(name, sale.get(name)+amount);
		}
		else{
			sale.put(name,amount);
		}
	}
	
	public String toString(){
		String output="";
		output += super.toString()+"\n";
		output += "Sales per customer:"+"\n";
		for(String str : sale.keySet()){
			output += str+":"+(sale.get(str))+"kg"+"\n";
		}
		return output;
	}
	
	public int calculateBonus(){
		int index = 0;
		for(String str : sale.keySet()){
			if(sale.get(str)>=20){
				index++;
			}
		}
		
		if(index<5){
			return 0;
		}
		
		if(index>=5 && index<10){
			return 5;
		}
		else{
			return 7;
		}
			
	}
	public static void main(String[] args) {
		BonusSeller bon = new BonusSeller("Charles");
		bon.sale("Monsanto",13);
		bon.sale("ICI",35);
		System.out.println(bon.toString());
	}
}
