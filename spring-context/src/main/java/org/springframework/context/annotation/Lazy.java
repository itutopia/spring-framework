/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates whether a bean is to be lazily initialized.
 *
 * 指示是否延迟初始化bean.
 *
 * <p>May be used on any class directly or indirectly annotated with {@link
 * org.springframework.stereotype.Component @Component} or on methods annotated with
 * {@link Bean @Bean}.
 *
 * <p>If this annotation is not present on a {@code @Component} or {@code @Bean} definition,
 * eager initialization will occur. If present and set to {@code true}, the {@code @Bean} or
 * {@code @Component} will not be initialized until referenced by another bean or explicitly
 * retrieved from the enclosing {@link org.springframework.beans.factory.BeanFactory
 * BeanFactory}. If present and set to {@code false}, the bean will be instantiated on
 * startup by bean factories that perform eager initialization of singletons.
 *
 * 如果{@code@Component}或{@code@Bean}定义中不存在此注释，将进行紧急初始化。
 * 如果存在并设置为{@code true}，{@code @Bean}或{@code@Component}在被另一个bean引用或显式引用之前不会初始化.
 * 从封闭的{@link org.springframework.beans.factory.BeanFactory}中检索Bean工厂。
 * 如果存在并设置为{@code false}，bean将在由执行单例初始化的bean工厂启动。
 *
 * <p>If Lazy is present on a {@link Configuration @Configuration} class, this
 * indicates that all {@code @Bean} methods within that {@code @Configuration}
 * should be lazily initialized. If {@code @Lazy} is present and false on a {@code @Bean}
 * method within a {@code @Lazy}-annotated {@code @Configuration} class, this indicates
 * overriding the 'default lazy' behavior and that the bean should be eagerly initialized.
 *
 * 如果{@link Configuration}类上存在Lazy注解，则指示该{@cod e@Configuration}中的所有{@code@Bean}方法应该延迟初始化。
 * 如果{@code@Lazy}在{@code@Bean}上存在且为false方法在{@code@Lazy}注释的{@code@Configuration}类中，这表明重写“默认惰性”行为，并且应该急切地初始化bean。
 *
 * <p>In addition to its role for component initialization, this annotation may also be placed
 * on injection points marked with {@link org.springframework.beans.factory.annotation.Autowired}
 * or {@link jakarta.inject.Inject}: In that context, it leads to the creation of a
 * lazy-resolution proxy for all affected dependencies, as an alternative to using
 * {@link org.springframework.beans.factory.ObjectFactory} or {@link jakarta.inject.Provider}.
 * Please note that such a lazy-resolution proxy will always be injected; if the target
 * dependency does not exist, you will only be able to find out through an exception on
 * invocation. As a consequence, such an injection point results in unintuitive behavior
 * for optional dependencies. For a programmatic equivalent, allowing for lazy references
 * with more sophistication, consider {@link org.springframework.beans.factory.ObjectProvider}.
 *
 * 除了用于组件初始化之外，还可以放置此注释在用
 * {@link org.springframework.beans.factory.annotation.Autowired}标记的注入点上
 * 或者{@link jakarta.inject.Inject}：在这种情况下，它会导致创建所有受影响依赖项的延迟解析代理，
 * 作为使用{@link org.springframework.beans.factory.ObjectFactory}或{@link jakarta.inject.Provider}。
 * 请注意，这样的延迟解析代理将始终被注入；如果目标依赖关系不存在，您只能通过召唤。因此，这样的注入点会导致非直觉行为用于可选依赖项。
 * 对于编程等价物，允许延迟引用更复杂的是，考虑{@链接org .prprgFrrase.Bea.Studio.ObjtServices }。
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.0
 * @see Primary
 * @see Bean
 * @see Configuration
 * @see org.springframework.stereotype.Component
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lazy {

	/**
	 * Whether lazy initialization should occur.
	 */
	boolean value() default true;

}
