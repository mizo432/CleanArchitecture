package jp.or.venuspj.utils;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Objects2Test {

    @Test
    public void nonNull1(){
        assertThat(Objects2.nonNull(null)).isFalse();
        assertThat(Objects2.nonNull(1)).isTrue();
    }
}
