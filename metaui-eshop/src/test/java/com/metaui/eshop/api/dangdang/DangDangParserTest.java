package com.metaui.eshop.api.dangdang;

import com.metaui.eshop.api.domain.Category;
import org.junit.Test;

import java.util.List;

/**
 * @author wei_jc
 * @since 1.0
 */
public class DangDangParserTest {
    @Test
    public void parse() throws Exception {
        DangDangParser parser = new DangDangParser();
        List<Category> list = parser.parse();
        for (Category category : list) {
            System.out.println(category.getName() + "  --> " + category.getDesc());
        }
    }

}