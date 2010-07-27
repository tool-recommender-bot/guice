/*
 *    Copyright 2010 The myBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.guice.transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Connection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.TransactionIsolationLevel;

/**
 * Any method or class marked with this annotation will be considered for
 * transactionality.
 *
 * @version $Id$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {

    /**
     * Returns the constant indicating the iBatis executor type.
     *
     * @return the constant indicating the iBatis executor type.
     */
    ExecutorType executorType() default ExecutorType.SIMPLE;

    /**
     * Returns the constant indicating the transaction isolation level.
     *
     * @return the constant indicating the transaction isolation level.
     */
    TransactionIsolationLevel isolationLevel() default TransactionIsolationLevel.NONE;

    /**
     * Flag to indicate that iBatis has to force the transaction {@code commit().}
     *
     * @return false by default, user defined otherwise.
     */
    boolean force() default false;

    /**
     * Flag to indicate the auto commit policy on the {@link Connection}.
     *
     * @return false by default, user defined otherwise.
     */
    boolean autoCommit() default false;

    /**
     * The exception re-thrown when an error occurs during the transaction.
     *
     * @return the exception re-thrown when an error occurs during the
     *         transaction.
     */
    Class<? extends Throwable> rethrowExceptionsAs() default Exception.class;

}
