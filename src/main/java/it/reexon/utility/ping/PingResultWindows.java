/**
 * Copyright (c) 2016 Marco Velluto
 */
package it.reexon.utility.ping;

import java.util.List;

public class PingResultWindows extends PingResult
{

    protected PingResultWindows(List<String> pingOutput)
    {
        super(pingOutput);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#parsePayload(java.util.List)
     */
    @Override
    protected int parsePayload(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchTransmitted(java.util.List)
     */
    @Override
    protected int matchTransmitted(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchReceived(java.util.List)
     */
    @Override
    protected int matchReceived(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchTime(java.util.List)
     */
    @Override
    protected int matchTime(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchRttMin(java.util.List)
     */
    @Override
    protected float matchRttMin(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchRttAvg(java.util.List)
     */
    @Override
    protected float matchRttAvg(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchRttMax(java.util.List)
     */
    @Override
    protected float matchRttMax(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchRttMdev(java.util.List)
     */
    @Override
    protected float matchRttMdev(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchIP(java.util.List)
     */
    @Override
    protected String matchIP(List<String> lines)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.reexon.utility.ping.PingResult#matchTTL(java.util.List)
     */
    @Override
    protected int matchTTL(List<String> lines)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
