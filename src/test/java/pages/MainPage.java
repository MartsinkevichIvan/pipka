package pages;

import blocks.SearchBlock;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.PageObject;

@PageObject
@Getter
public class MainPage extends AbstractPage{
    @Autowired
    SearchBlock searchBlock;
}
