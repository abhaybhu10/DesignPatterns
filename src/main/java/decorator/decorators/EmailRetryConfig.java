package decorator.decorators;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailRetryConfig {
    int retryCount;
}
