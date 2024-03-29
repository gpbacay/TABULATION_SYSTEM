package Classes;

/**
 *
 * @author Gianne Bacay
 */
public class Result {
    private int result_id, judge_id, candidate_id, category_id, criterion_id, rank_num;
    
    // Constructors
    public Result() {
        this.result_id = 0;
        this.judge_id = 0;
        this.candidate_id = 0;
        this.category_id = 0;
        this.criterion_id = 0;
        this.rank_num = 0;
    }
    
    public Result(int result_id, int judge_id, int candidate_id, int category_id, 
            int criterion_id, int rank_num) {
        this.result_id = result_id;
        this.judge_id = judge_id;
        this.candidate_id = candidate_id;
        this.category_id = category_id;
        this.criterion_id = criterion_id;
        this.rank_num = rank_num;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getJudge_id() {
        return judge_id;
    }

    public void setJudge_id(int judge_id) {
        this.judge_id = judge_id;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCriterion_id() {
        return criterion_id;
    }

    public void setCriterion_id(int criterion_id) {
        this.criterion_id = criterion_id;
    }

    public int getRank_num() {
        return rank_num;
    }

    public void setRank_num(int rank_num) {
        this.rank_num = rank_num;
    }

    @Override
    public String toString() {
        return "Result{" + "result_id=" + result_id + ", judge_id=" + judge_id + 
                ", candidate_id=" + candidate_id + ", category_id=" + category_id + 
                ", criterion_id=" + criterion_id + ", rank_num=" + rank_num + '}';
    }
}
