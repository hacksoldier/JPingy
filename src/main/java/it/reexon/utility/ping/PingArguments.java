/**
 * 
 */
package it.reexon.utility.ping;

/**
 * @author marco.velluto
 */
public class PingArguments
{
    String url;
    Integer count;
    Long timeout;
    Integer payload_bytes;
    Integer interval;
    Integer ttl;

    public static class Builder
    {

        private PingArguments arguments;

        public Builder()
        {
            this.arguments = new PingArguments();
        }

        public Builder setUrl(String url)
        {
            this.arguments.url = url;
            return this;
        }

        public Builder setCount(int count)
        {
            this.arguments.count = count;
            return this;
        }

        public Builder setTimeout(long timeout)
        {
            this.arguments.timeout = timeout;
            return this;
        }

        public Builder setBytes(int bytes)
        {
            this.arguments.payload_bytes = bytes;
            return this;
        }

        public Builder setTtl(int ttl)
        {
            this.arguments.ttl = ttl;
            return this;
        }

        /**
         * -i
         * 
         * @param interval
         * @return
         */
        public Builder setInterval(Integer interval)
        {
            this.arguments.interval = interval;
            return this;
        }

        public PingArguments build()
        {
            return arguments;
        }
    }
}
