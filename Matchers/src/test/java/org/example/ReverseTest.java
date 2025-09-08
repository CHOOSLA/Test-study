package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReverseTest {

    @Test
    public void testReverseName(){
        // given
        Reverse reverse = new Reverse();

        // when
        String input = "추창우";

        // then
        assertThat(reverse.reverse(input)).isEqualTo("우창추");
    }

    @Test
    public void testReverse(){
        Reverse reverse = new Reverse();

        String input = null;
        assertThatThrownBy(() -> reverse.reverse(input))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testReverse2(){
        Reverse reverse = new Reverse();

        String input = "";
        assertThatThrownBy(() ->
        {if (reverse.reverse(input).equals(""))
        throw new IllegalArgumentException();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testExceptionMessage2(){
        assertThatThrownBy(()->{
            int t = 3 / 0;
        }).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void testExceptionMessage3(){
        assertThatThrownBy(()->{
            throw new RuntimeException("에러다!!");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("에러다");
    }
}
