package RMate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Created by User on 2015/09/13.
 */
@Entity
public class Reading implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="chip_id")
    private Chip chip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cycler_id")
    private Cycler cycler;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reader_id")
    private Reader reader;

    private Date readTime;

    public Reading(){

    }

    public Reading(Builder builder){
        chip = builder.chip;
        cycler = builder.cycler;
        reader = builder.reader;
        readTime = builder.readTime;

    }

    public Long getReadingId(){return id;}
    public Chip getChip(){return chip;}
    public Cycler getCycler(){return cycler;}
    public Reader getReader(){return reader;}
    public Date getReadTime(){return readTime;}

    public static class Builder{
        private Chip chip;
        private Cycler cycler;
        private Reader reader;
        private Date readTime;


        public Builder(Chip value){
            this.chip = value;
        }
        public Builder cycler(Cycler value){
            this.cycler = value;
            return this;

        }
        public Builder reader(Reader value){
            this.reader = value;
            return this;
        }
        public Builder readTime(Date value){
            this.readTime = value;
            return this;
        }
        public Builder copy(Reading value){
            this.chip = value.chip;
            this.cycler = value.cycler;
            this.reader = value.reader;
            this.readTime = value.readTime;
            return this;
        }

        public Reading build(){
            return new Reading(this);
        }
    }
}
