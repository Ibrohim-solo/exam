package uz.book.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.MultiValueMap;
@Builder
@Data
@AllArgsConstructor
public class ResponseDto<V> {
    private Integer code;
    private String message;
    private Boolean succes;
    private V data;
    private MultiValueMap<Integer, Integer> list;
}
