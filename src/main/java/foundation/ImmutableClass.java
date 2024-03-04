package foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final int immutableField1;
    private final String immutableField2;
    private final List<Integer> mutableField;

    public ImmutableClass(int immutableField1, String immutableField2, List<Integer> mutableField) {
        this.immutableField1 = immutableField1;
        this.immutableField2 = immutableField2;

        /**
         * 这里可以看到我们有两种写法,
         *   第一种写法就是我们说的保护性防御,对于可变字段mutableField，进行了防御性拷贝,即创建一个新的ArrayList，并将原始mutableField的内容拷贝到新的ArrayList中,
         * 这种做法会创建一个新的List对象，防止可变字段在外部被修改后改变了不可变对象的行为。
         *   第二种写法直接将传入的mutableField引用赋值给了类中的mutableField字段。这种做法并没有进行防御性拷贝，因此如果外部的代码修改了mutableField的内容,不可变对象
         * 的状态也会受到影响，违反了不可变类的设计原则。
         */
        this.mutableField = new ArrayList<>(mutableField);
//        this.mutableField = mutableField;

    }

    public int getImmutableField1() {
        return immutableField1;
    }

    public String getImmutableField2() {
        return immutableField2;
    }

    public List<Integer> getMutableField() {
        return Collections.unmodifiableList(mutableField);
    }
}