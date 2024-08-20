public class StaticStack {
    public String vet[];
    public int top;

    public StaticStack(int length){
        this.vet = new String[length];
        this.top = 0;
    }

    public boolean isFull() {
        return this.vet.length <= top;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public boolean push(String value){
        if(isFull()){
            return false;
        }
        this.vet[top] = value;
        top++;
        return true;
    }

    public String pop(){
        if(isEmpty()){
            return null;
        }
        this.top--;
        String popped = this.vet[top];
        this.vet[top] = null;
        return popped;
    }
}
