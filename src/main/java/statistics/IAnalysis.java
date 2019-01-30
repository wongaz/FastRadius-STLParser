package statistics;

import model.Model;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Serializable;
import java.util.Map;


public interface IAnalysis extends Serializable {
    Pair<String, Object> runAnalysis(Model model, Map<String, String> statisticsConf);
}
