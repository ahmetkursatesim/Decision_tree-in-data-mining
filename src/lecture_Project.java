
import weka.core.Instances;
 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lecture_Project implements call {
	
	

    
	public static void main(String[] args) throws IOException {
		 int c =0;
	        int b=0;
	        int set=0;
	        int r=0;
	        int y=0;
	        int length;
		lecture_Project a=new lecture_Project();
		
		a.importance();
		a.drawtree();
		 BufferedReader reader = new BufferedReader( new FileReader("C:\\Users\\Ahmet\\Desktop\\Blood-Difusion.arff"));
        Instances data = new Instances(reader);
     
       
         length = data.numInstances();
         String [][] ar=new String [length][length];  
   
     for(int x=0;x<data.numInstances();x++) {
    	ar[x][0]= Double.toString((double) data.instance(x).value(0));
    	ar[x][1]= Double.toString((double) data.instance(x).value(1));
    	ar[x][2]= Double.toString((double) data.instance(x).value(2));
    	ar[x][3]= Double.toString((double) data.instance(x).value(3));
    	ar[x][4]= Integer.toString((int)data.instance(x).value(4));
    
  
 
    
    	
    	 
    	 
    	
     }
     
     
    
   
        reader.close();
    	
    	
		double rt=stdev(ar,length,0);
		double rt1=stdev(ar,length,1);
		double rt2=stdev(ar,length,2);
		double rt3=stdev(ar,length,3);
		a.gainty(ar, length, rt,0);
     
		a.gainty(ar, length, rt1,1);
		a.gainty(ar, length, rt2,2);
		a.gainty(ar, length, rt3,3);
     
		
	

	    	
	     }
	
		public void  gainty(String ar[][],int length,double rt,int durum) {
			double  gain=0;
			int total=748;
		double a=entropy(570.0,178.0);
		    double b  = condition1(ar,length,rt,durum,0);
		     int c=   condition1(ar,length,rt,durum,1);
		     int d=   condition2(ar,length,rt,durum,1);
		     int p=   condition2(ar,length,rt,durum,0);
		     double t1=b+c;
		     double t2=d+p;
		        gain=a-(t1/total)*entropy(b,c)-(t2/total)*entropy(d,p);
			
		        System.out.print(gain);
		        
			
		}
	
	
	
	
	
	
	
	public static int condition1 (String ar[][], int length,double rt,int second,int durum) {
		
		
        int x=0;
        
	for(int d=0;d<length;d++) {
		    
	    	if (durum==0) {
	    	if(Double.parseDouble(ar[d][second])>rt && Integer.parseInt(ar[d][4])==0) {
	    		x++;
	    		
	    		
	    	}
	    	}
	    	else {
	    		
	    	
	        if(Double.parseDouble(ar[d][second])>rt && Integer.parseInt(ar[d][4])==1) {
	    		
	    		x++;
	    		
	    	}
	    	
	     }
        
	}
		
		return x;
		
		
		
	}
	public static int condition2(String ar[][], int length,double rt,int second,int durum) {
		int x=0;
		
		
	for(int d=0;d<length;d++) {
		    if(durum==0) {
	    	
	    	if(Double.parseDouble(ar[d][second])<=rt && Integer.parseInt(ar[d][4])==0) {
	    		x++;
	    		
	    		
	    	}
		    }
		    else {
	    	    if(Double.parseDouble(ar[d][second])<=rt && Integer.parseInt(ar[d][4])==1) {
	    		
	    		x++;
	    	}
		    }
	}
		return x;
		
		
		
		
	}
	
	public static double stdev(String ar[][],int length,int second) {
		double x=0;
		double mean;
		double stdev = 0;
		mean=mean(ar,length,second);
		for(int u=0;u<length;u++) {
			
			stdev+=Math.pow(mean-Double.parseDouble(ar[u][second]),2);
			
			
			
		}
	 x=Math.sqrt(stdev/(length-1));
		
		
		 
		
		return x;
	}
	
	
	public static double mean(String ar[][],int length,int second) {
		
		
		double y=0;
		for(int h=0;h<length;h++) {
			
			y+=Double.parseDouble(ar[h][second]);
			
		}
		
		
		return y/length;
		
		
		
		
	}
	public double entropy(double a,double b) {
		double x = 0;
		if(b!=0.0 && a!=0.0 ) {
		x=-((a/(a+b))*(Math.log10(a/(a+b))/Math.log10(2)))-((b/(a+b))*(Math.log10(b/(a+b))/Math.log10(2)));
		}
		else if(a==0.0 ) {
			x=-((b/(a+b))*(Math.log10(b/(a+b))/Math.log10(2)));
		}
		else if(b==0.0) {
			x=-((a/(a+b))*(Math.log10(a/(a+b))/Math.log10(2)));
		
		}
		else if(b==0.0) {
			
			x=-((a/(a+b))*(Math.log10(a/(a+b))/Math.log10(2)));
			
		}
	
		
		
		return x ;
		
	}
	public double gainInfo(double a,double b,double c,double d) {
		
		double y=0;
		
	
		
		return y;
	}

	@Override
	public void drawtree() {
		// TODO Auto-generated method stub
		System.out.println("ahmet");
	}
	@Override
	public void importance() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
