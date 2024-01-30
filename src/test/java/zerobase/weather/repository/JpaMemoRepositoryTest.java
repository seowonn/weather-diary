package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    private JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo newMemo = new Memo(10, "this is jpa memo");
        // when
        jpaMemoRepository.save(newMemo);
        // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertFalse(memoList.isEmpty());
    }

    @Test
    void findByIdTest() {
        // given
        Memo newMemo = new Memo(11, "jpa");
        // when
        Memo memo = jpaMemoRepository.save(newMemo);
        System.out.println(memo.getId());
        // then
        // 에러가 뜸. 이유 : key값이 내가 넣은 11이 아닌, DB에서 자동생성된 것이기 때문
//        Optional<Memo> result = jpaMemoRepository.findById(11);

        // 제대로 동작되는 코드
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals("jpa", result.get().getText());
    }

}