package utils.pageUtils;

import blocks.FilterBlock;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Getter
@Component
public class FilterBlockUtil {

    FilterBlock filterBlock;

    public void filterContentBy(){

        var element = filterBlock.getFiltersList().stream().filter(x->x.getText().equals("Все")).findFirst();

        if(element.isPresent()){
            element.get().click();
        }
    }
}
