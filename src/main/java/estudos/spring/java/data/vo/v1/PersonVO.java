package estudos.spring.java.data.vo.v1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
