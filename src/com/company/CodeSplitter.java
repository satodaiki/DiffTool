package com.company;

import java.util.List;

/**
 * コード分割インターフェース
 *
 * コードがどの言語にも対応できるよう定義
 */
public interface CodeSplitter {
    public List<Object> split();
}
