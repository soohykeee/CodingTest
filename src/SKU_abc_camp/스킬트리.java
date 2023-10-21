package SKU_abc_camp;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String tempSkill = skillTree;

            for (int i = 0; i < skillTree.length(); i++) {
                String s = skillTree.substring(i, i + 1);
                if (!skill.contains(s)) {
                    tempSkill = tempSkill.replace(s, "");
                }
            }
            if (skill.indexOf(tempSkill) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        스킬트리 T = new 스킬트리();

        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
