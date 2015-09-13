package RMate.model;

import RMate.domain.Cycler;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by User on 2015/09/13.
 */
public class ChipResource extends ResourceSupport {
    private Long resid;

    private Cycler cycler;

    public ChipResource(){

    }

    public ChipResource(Builder builder){
        cycler = builder.cycler;
        resid = builder.resid;
    }
    public Cycler getCycler(){return cycler;}

    public Long getResid(){return resid;}

    public static class Builder{
        private Cycler cycler;
        private Long resid;

        public Builder (Cycler value){
            this.cycler = value;
        }

        public Builder resid(Long value) {this.resid = value; return this;}

        public Builder copy(ChipResource value){
            this.cycler = value.cycler;
            this.resid = value.resid;
            return this;
        }
        public ChipResource build() {
            return new ChipResource(this);
        }
    }
}

