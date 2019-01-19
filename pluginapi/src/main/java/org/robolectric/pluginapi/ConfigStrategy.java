package org.robolectric.pluginapi;

import java.lang.reflect.Method;
import java.util.Collection;

public interface ConfigStrategy {

  /**
   * Determine the configuration for the given test class and method.
   *
   * Since a method may be run on multiple test subclasses, {@param testClass} indicates which
   * test case is currently being evaluated.
   *
   * @param testClass the test class being evaluated; this might be a subclass of the method's
   *     declaring class.
   * @param method the test method to be evaluated
   * @return the set of configs
   */
  ConfigCollection getConfig(Class<?> testClass, Method method);

  /**
   * Heterogeneous typesafe collection of configuration objects managed by their {@link Configurer}.
   */
  interface ConfigCollection {

    /** Returns the configuration instance of the specified class for the current test. */
    <T> T get(Class<T> configClass);

    /** Returns the set of known configuration classes. */
    Collection<Class<?>> keySet();
  }
}