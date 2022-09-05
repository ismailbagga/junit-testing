package coder.springframework.testing.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Owner {
    private Long id ;
    private String firstName , lastName ;

    public List<Object> getProducts() {
        throw new UnsupportedOperationException() ;
    }

    public void longTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
