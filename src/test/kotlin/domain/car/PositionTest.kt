package domain.car

import domain.car.Position.Companion.MIN_POSITION
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PositionTest {
    companion object {
        private val DEFAULT_POSITION = Position(MIN_POSITION)
        private val MOVED_POSITION = Position(MIN_POSITION + 1)
    }

    @Test
    fun `position은 기본위치 생성이 가능하다`() {
        val position = Position.default()

        assertAll(
            { assertThat(position).isInstanceOf(Position::class.java) },
            { assertThat(position).isEqualTo(DEFAULT_POSITION) }
        )
    }

    @Test
    fun `position은 최솟값 이하로 생성 할 경우 예외를 발생시킨다`() {
        assertThatThrownBy { Position(MIN_POSITION - 1) }
            .isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    fun `increase는 position을 증가시킨다`() {
        assertThat(DEFAULT_POSITION.increase()).isEqualTo(MOVED_POSITION)
    }
}
