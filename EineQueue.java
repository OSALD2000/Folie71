public class EineQueue<T> extends Queue<T>{
    
    private int anfang;
    private int ende;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public EineQueue(){
        this.queue = (T[]) new Object[10];
        this.anfang=0;
        this.ende=0;
    }

    @Override
    public void put(T element) {
        if(ende+1 <= this.queue.length ){
            this.growIfNeeded();
            queue[this.ende++]=element;
        } else {
            ende=0;
            this.put(element);
        }

    }

    @Override
    public T get() {
        if(anfang +1 <= this.queue.length){
            T element = queue[anfang];
            queue[anfang++]=null;
            return element;
        }else{
            anfang=0;
            return this.get();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.queue[ende]==null ;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void growIfNeeded() {
        if(!this.isEmpty()){
            T[] newQueue = (T[]) new Object[this.queue.length*2];
            for(int i=0 ; i<this.queue.length; i++){
                newQueue[i]=this.get();
            }
            anfang=0;
            ende=this.queue.length;
            this.queue=newQueue;
        }
    } 

    @Override
    public String toString() {
        String queueInhalt = "";
        for(T element : this.queue){
            if(element!=null){
                queueInhalt += "< "+element + " > ";
            }else{
                queueInhalt +="< > ";
            }
        }  
        return queueInhalt;
    }


}