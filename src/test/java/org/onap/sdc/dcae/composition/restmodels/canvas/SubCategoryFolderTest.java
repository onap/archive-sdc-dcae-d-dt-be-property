package org.onap.sdc.dcae.composition.restmodels.canvas;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertThat;

public class SubCategoryFolderTest {
    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(DcaeComponentCatalog.SubCategoryFolder.class, hasValidGettersAndSetters()); }
}
