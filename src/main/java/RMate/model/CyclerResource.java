package RMate.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by User on 2015/09/13.
 */
public class CyclerResource extends ResourceSupport {
    private Long resid;
    private String first;
    private String last;
    private int age;

    public CyclerResource(){

    }

    public CyclerResource(Builder builder){
        resid = builder.resid;
        first = builder.first;
        last = builder.last;
        age = builder.age;
    }
    public Long getResId(){return resid;}
    public String getFirst(){return first;}
    public String getLast(){return last;}
    public int getAge(){return age;}


    public static class Builder{
        private Long resid;
        private String first;
        private String last;
        private int age;

        public Builder(Long value){this.resid= value;}
        public Builder first(String value){this.first = value; return this;}
        public Builder last(String value){this.last = value; return this;}
        public Builder age(int value){this.age = value; return this;}

        public Builder copy(CyclerResource value){
            this.resid = value.resid;
            this.first = value.first;
            this.last = value.last;
            this.age = value.age;
            return this;
        }
        public CyclerResource build(){return new CyclerResource(this);}
    }


}

