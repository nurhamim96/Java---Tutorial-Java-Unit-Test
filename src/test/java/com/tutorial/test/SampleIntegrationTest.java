package com.tutorial.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {

    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }
}

/*
NOTE :
* Gunakan annotation @Tag bila ingin melakukan grouping test
* Gunakan annotation @Tags bila lebih dari 1 tag
* Jalankan menggunakan maven -> mvn test -Dgroups=tag1,tag2 dsb. bisa lebih dari 1 tag.
* Contoh : mvn test -Dgroups=integration-test
* Jalankan menggunakan Intellij Idea pilih Edit Configuration -> klik + -> pilih Junit
* Pada Tag Expression gunakan koma bila lebih dari satu.
* */
