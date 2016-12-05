package algoritmos;
//
//public class Pq {
//	int size;
//	Pqnode []arr=new Pqnode[5];
//   public Pq(){
//      size=0;
//      arr[0]=new Pqnode(-1);
//   }
//	
//	
//	class Pqnode{
//		int key;
//		int order;
//		public Pqnode(int key ){
//			this.key=key;
//			this.order=1;
//			
//		}
//	}
//	
//
//	
//	void add(int key){
//		int pos=size+1;
//      if(size>=arr.length-1)ResizeArr();
//		Pqnode newnode=new Pqnode(key);
//		arr[pos]=newnode;
//		while(pos!=0){
//			
//			if(arr[pos].key<arr[pos/2].key){
//				Pqnode change=arr[pos];
//				arr[pos]=arr[pos/2];
//				arr[pos/2]=change;
//				pos=pos/2;
//				
//			}
//			else
//				break;
//			
//			
//				
//			}
//      size++;
//		}
//	
//		
//	
//	
//	void pop(){
//		
//	}
//	
//	Pqnode peek(){
//		return arr[1];
//		
//	}
//	int size(){
//		return size;
//	}
//	 void ResizeArr(){
//			Pqnode temp[]=new Pqnode [size*2];
//			for (int i=0;i<=size;i++)
//				temp[i]=arr[i];
//			arr=temp;
//		}
//	 public static void main(String [] args){
//		 Pq p=new Pq();
//		 p.add(5);
//		 p.add(3);
//		 p.add(15);
//		 p.add(2);
//		p.add(1);
//		 
//		 
//}
//
//
//}

class nodes{
	int key;
	int odll;//orden de llegada
	
	nodes(int k){
		this.key = k;
		this.odll = 1;
	}
}
// donde la prioridad son los numeros mas pequqnos
public class Pq {
	int size;
	nodes[] arr = new nodes[5];
	
	
	
	void add(int k){
		//nodes n = new nodes(k);
		nodes curr;
		int i = size +1;
		if(size==arr.length-1)resize();

		arr[i] = new nodes(k);
		arr[i].odll=i;
		size++;
		int j =i/2;
		if(size>1){
			while(arr[i].key < arr[j].key){
				
					
				
				curr = arr[i];
				arr[i] =arr[j];
				arr[j] = curr;
				arr[i].odll=i;
				arr[j].odll=j;
				i= j;
				j =i/2;
				if(i<=0 || j<=0)
					break;
			
			}
		}
		
	}
	int pop()throws Exception{
		if(size==0)throw new Exception();
		int ret=arr[1].key;
		int i=1;
		int j=0;
		int m=0;
		arr[i].key=arr[size].key;
		arr[size].key=0;//null
		arr[size]=null;
		
		nodes curr=arr[1];
		if(size==1){
			arr[i]=null;
			size--;
			return ret;
		}
		
		//int j=i/2;
		int l=2*i;
		int r=2*i+1;
		if(arr[l]==null){
			j=l;
		}
		else{
		 m=Math.min(arr[l].key, arr[r].key);
		
		
		if(m==l)j=2*i;
		else
			j=2*i+1;
		}
		while(arr[j].key < arr[i].key){
			curr = arr[i];
			arr[i] =arr[j];
			arr[j] = curr;
			arr[i].odll=i;
			arr[j].odll=j;
			i= j;
			 l=2*i;
			 r=2*i+1;
			 if(r>size)
				 j=l;
			 else{
				 
			  m=Math.min(arr[l].key, arr[r].key);
			
			
			if(m==arr[l].key)j=l;
			else
				j=r;
			 }
			if(i>size || j>size)
				break;
		}
		//int s=arr[size].key;
		
		return 0;
		
	}
	int peek()throws Exception{
		if(size==0)throw new Exception();
		return arr[1].key;
	}
	
	void update(int i, int key)throws Exception {
		if (size==0)throw new Exception();
		if(i>size)throw new Exception();
		nodes cur=arr[i];
		int parent=i/2;
		int l=i*2;
		int r=(i*2)+1;
		int  j, m;
		cur.key=key;
		
		if(arr[i].key<arr[parent].key){
			//up heap
			
             while(arr[parent].key < arr[i].key){
			
				cur = arr[i];
				arr[i] =arr[parent];
				arr[parent] = cur;
				arr[i].odll=i;
				arr[parent].odll=parent;
				i= parent;
				parent =i/2;
				if(i<=0 || parent<=0)
					break;
			
			}
             
		}
		else{
			
			if(arr[r]==null){
				j=l;
			}
			else{
			 m=Math.min(arr[l].key, arr[r].key);
			
			
			if(m==arr[l].key)j=2*i;
			else
				j=(2*i)+1;
			}
			while(arr[j].key < arr[i].key){
				cur = arr[i];
				arr[i] =arr[j];
				arr[j] = cur;
				arr[i].odll=i;
				arr[j].odll=j;
				i= j;
				 l=2*i;
				 r=(2*i)+1;
				 if(r>size)
					 j=l;
				 else{
					 
				  m=Math.min(arr[l].key, arr[r].key);
				
				
				if(m==arr[l].key)j=l;
				else
					j=r;
				 }
				if(i>size || j>size)
					break;
			}
			
		}
		
		
		//return 0;
	}
	
	
	
	private void resize() {
		// TODO Auto-generated method stub
		nodes[] tmp = new nodes[2*arr.length];
		for(int i=1; i<=size;i++){
			tmp[i]=arr[i];
		}
		arr = tmp;
	}

	void display(){
		for(int i=1;i<=size;i++){
			System.out.println(arr[i].key);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pq pq = new Pq();
		pq.add(5);
		pq.add(3);
		pq.add(15);
		pq.add(2);
		pq.add(23);
		pq.add(1);
		pq.add(2);
		pq.add(5);
		
		try{
			pq.update(2, 24);
		//pq.pop();
		}catch(Exception e){}
		pq.display();
		

	}

}
