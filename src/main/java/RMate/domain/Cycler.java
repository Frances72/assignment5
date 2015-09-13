package RMate.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by User on 2015/09/13.
 */
@Entity
public class Cycler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first;
    private String last;
    private int age;

    private Cycler(){

    }

    private Cycler(Builder builder){
        first = builder.first;
        last = builder.last;
        age = builder.age;
        id  = builder.id;
    }

    public Long getCyclerID(){return id;}

    public String getFirst(){return first;}

    public String getLast(){return last;}

    public int getAge(){return age;}

    public static class Builder {
        private String first;
        private String last;
        private int age;
        private Long id;


        public Builder(String first) {
            this.first = first;
        }

        public Builder last(String value) {
            this.last = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }
        public Builder copy(Cycler value){
            this.first = value.first;
            this.last = value.last;
            this.age = value.age;
            return this;

        }
        public Cycler build(){
            return new Cycler(this);
        }
    }

}
