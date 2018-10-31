package org.onap.sdc.dcae.composition.restmodels.canvas;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertThat;

public class SubCategoryFolderTest {
    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(DcaeComponentCatalog.SubCategoryFolder.class, hasValidGettersAndSetters()); }

    @Test
    public void testHasValidConstructor() {
        assertThat(DcaeComponentCatalog.SubCategoryFolder.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(DcaeComponentCatalog.SubCategoryFolder.class, hasValidBeanHashCodeFor());
    }
}
