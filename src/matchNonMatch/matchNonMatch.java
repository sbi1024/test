package matchNonMatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class matchNonMatch {
    public static Map<String, Object> checkSchUser(List<Map<String, Object>> originalUser, List<Map<String, Object>> newUser) {

        // 반환 결과 변수
        Map<String, Object> result = new HashMap<>();
        // null 값으로 매겨변수 값이 들어올 경우 , 해당 메소드 return 문으로 종료
        if (originalUser == null || newUser == null) {
            return result;
        }

        // 빈값이 들어온다면 , return
        if (originalUser == null || newUser == null) {
            return result;
        }

        try {
            // 일치하는 참여자 목록 즉 , 기존 참여자 목록
            List<Map<String, Object>> match = newUser.stream()
                    .filter(filter -> originalUser.stream()
                            .anyMatch(target -> filter.get("empSeq").equals(target.get("empSeq")))
                    ).collect(Collectors.toList());
            result.put("match", match);

            // 일치하지 않는 참여자 목록 즉 , 추가된 참여자 목록
            List<Map<String, Object>> nonMatch = newUser.stream()
                    .filter(filter -> originalUser.stream()
                            .noneMatch(target -> filter.get("empSeq").equals(target.get("empSeq")))
                    ).collect(Collectors.toList());
            result.put("nonMatch", nonMatch);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("checkSchUser Exception $$$  " + e.getMessage());
        }

        return result;
    }
}
