package az.farhad.library.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ElibraryExceptions extends RuntimeException{
    Integer code;
    public ElibraryExceptions(Integer code, String message){
        super(message);
        this.code=code;
    }
    public Integer getCode(){
        return code;
    }
}
