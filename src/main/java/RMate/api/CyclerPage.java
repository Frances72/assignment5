package RMate.api;

import RMate.domain.Cycler;
import RMate.model.CyclerResource;
import RMate.services.CyclerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/13.
 */
@RestController
@RequestMapping("/cyclerpage/**")
public class CyclerPage {
    @Autowired
    private CyclerService cyclerService;

    @RequestMapping(value="cyclerdisplay", method = RequestMethod.GET)

    public List<CyclerResource> getCyclers(HttpServletResponse response) throws Exception
    {
        try {
            List<CyclerResource> hateoas = new ArrayList<>();
            List<Cycler> cyclers = cyclerService.getAllCyclers();
            for (Cycler cycler : cyclers) {
                CyclerResource res = new CyclerResource
                        .Builder(cycler.getCyclerID())
                        .first(cycler.getFirst())
                        .last(cycler.getLast())
                        .age(cycler.getAge())
                        .build();
                String cyclerId = res.getResId().toString();
                Link cyclist = new Link("http://localhost:8183/cycler/" + cyclerId).withRel("cycler" + cyclerId);
                res.add(cyclist);
                hateoas.add(res);
            }
            return hateoas;
        }catch (Exception e){
            System.out.println("Exception in getCyclers." + e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            return null;
        }
    }
    //hello world for commit check

    @RequestMapping(value="createCycler", method = RequestMethod.POST)
    public void createCycler (@RequestBody CyclerResource cyclerResource, HttpServletResponse response) throws IOException
    {
        try {
            Cycler cycler = new Cycler.Builder(cyclerResource.getFirst())
                    .last(cyclerResource.getLast())
                    .age(cyclerResource.getAge())
                    .build();

            cyclerService.createCycler(cycler);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            System.out.println("Exception in createCycler method." + e);
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, e.getMessage());
        }
    }

    @RequestMapping(value="updateCycler", method = RequestMethod.POST)
    public void updateCycler (@RequestBody CyclerResource cyclerResource, HttpServletResponse response) throws IOException
    {
        try {
            Cycler cycler = new Cycler.Builder(cyclerResource.getFirst())
                    .last(cyclerResource.getLast())
                    .age(cyclerResource.getAge())
                    .id(cyclerResource.getResId())
                    .build();
            cyclerService.createCycler(cycler);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

        } catch (Exception e) {
            System.out.println("Exception in updateCycler method." + e);
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, e.getMessage());
        }
    }

    @RequestMapping(value="deleteCycler", method = RequestMethod.POST)
    public void deleteCycler (@RequestBody Long id, HttpServletResponse response) throws IOException
    {
        try {

            cyclerService.deleteCycler(id);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

        }catch (Exception e){
            System.out.println("Exception deleting record on Cycler ID method deleteCycler" + e);
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, e.getMessage());
        }
    }


    @RequestMapping(value="getCycler/{id}", method = RequestMethod.GET) // annnotation
    public Cycler getCycler (@PathVariable Long id, HttpServletResponse response) throws Exception
    {
        try {
            Cycler cycler = cyclerService.findCycler(id);
            return cycler;
        }catch (Exception e){
            System.out.println("Error on getCycler/{id} method." + e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            return null;
        }
    }

    @RequestMapping(value="createCycler2", method = RequestMethod.POST)
    public void createCycler (@RequestParam String first, @RequestParam String last,
                              @RequestParam int age, HttpServletResponse response) throws IOException
    {
        try {
            Cycler cycler = new Cycler.Builder(first)
                    .last(last)
                    .age(age)
                    .build();

            cyclerService.createCycler(cycler);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            System.out.println("Exception in createCycler method." + e);
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, e.getMessage());
        }
    }
}
