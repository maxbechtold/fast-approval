.. java:import:: javax.annotation Nonnull

.. java:import:: javax.annotation Nullable

Converter
=========

.. java:package:: com.nikolavp.approval.converters
   :noindex:

.. java:type:: public interface Converter<T>

   A converter interface. Converters are the objects in the approval system that convert your object to their raw form that can be written to the files. Note that the raw form is not always a string representation of the object. If for example your object is an image. User: nikolavp Date: 28/02/14 Time: 14:47

   :param <T>: the type you are going to convert to raw form

Methods
-------
getRawForm
^^^^^^^^^^

.. java:method:: @Nonnull  byte[] getRawForm(T value)
   :outertype: Converter

   Gets the raw representation of the type object. This representation will be written in the files you are going to then use in the approval process.

   :param value: the object that you want to convert
   :return: the raw representation of the object

