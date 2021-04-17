package example.custom.constraint.validator.example3;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, First.class, Second.class})
public interface Order {
}
