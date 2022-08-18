package ducnh.springboot.controller;

import ducnh.springboot.dto.UserDTO;
import ducnh.springboot.dto.WorkingHourDTO;
import ducnh.springboot.service.IWorkingHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/working-hour")
public class WorkingHourRestController {
    @Autowired
    IWorkingHourService workingHourService;

    @GetMapping("/find-working-hour")
    @Cacheable(key = "{#root.methodName,#id}", value = "user", unless = "#result == null")
    public ResponseEntity<WorkingHourDTO> findWorkingHourByUserId(@RequestParam Long id) {
        return new ResponseEntity<>(workingHourService.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/set")
    @CachePut(value = "user")
    @Secured("HR")
    public ResponseEntity<WorkingHourDTO> setWorkingHour(@RequestParam("id") Long id, @RequestBody WorkingHourDTO workingHour) {
        UserDTO user = new UserDTO();
        user.setId(id);
        workingHour.setUser(user);
        return new ResponseEntity<>(workingHourService.save(workingHour), HttpStatus.OK);
    }

}
