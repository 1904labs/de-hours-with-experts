package com.labs1904;

import org.junit.Assert;
import org.junit.Test;

public class TestNextBiggestNumberTest {

    @Test
    public void testSimpleCases() {
        Assert.assertEquals(21, NextBiggestNumber.getNextBiggestNumber(12));
        Assert.assertEquals(132, NextBiggestNumber.getNextBiggestNumber(123));
        Assert.assertEquals(67890, NextBiggestNumber.getNextBiggestNumber(67809));
    }

    @Test
    public void testNoNextBiggestNumberCases() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(21));
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(54321));
    }

    @Test
    public void test52210() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(52210));
    }

    @Test
    public void test95701() {
        Assert.assertEquals(95710, NextBiggestNumber.getNextBiggestNumber(95701));
    }

    @Test
    public void test71305() {
        Assert.assertEquals(71350, NextBiggestNumber.getNextBiggestNumber(71305));
    }

    @Test
    public void test6358() {
        Assert.assertEquals(6385, NextBiggestNumber.getNextBiggestNumber(6358));
    }

    @Test
    public void test25437() {
        Assert.assertEquals(25473, NextBiggestNumber.getNextBiggestNumber(25437));
    }

    @Test
    public void test49893() {
        Assert.assertEquals(49938, NextBiggestNumber.getNextBiggestNumber(49893));
    }

    @Test
    public void test76778() {
        Assert.assertEquals(76787, NextBiggestNumber.getNextBiggestNumber(76778));
    }

    @Test
    public void test2372() {
        Assert.assertEquals(2723, NextBiggestNumber.getNextBiggestNumber(2372));
    }

    @Test
    public void test45071() {
        Assert.assertEquals(45107, NextBiggestNumber.getNextBiggestNumber(45071));
    }

    @Test
    public void test31233() {
        Assert.assertEquals(31323, NextBiggestNumber.getNextBiggestNumber(31233));
    }

    @Test
    public void test50401() {
        Assert.assertEquals(50410, NextBiggestNumber.getNextBiggestNumber(50401));
    }

    @Test
    public void test57067() {
        Assert.assertEquals(57076, NextBiggestNumber.getNextBiggestNumber(57067));
    }

    @Test
    public void test40272() {
        Assert.assertEquals(40722, NextBiggestNumber.getNextBiggestNumber(40272));
    }

    @Test
    public void test54998() {
        Assert.assertEquals(58499, NextBiggestNumber.getNextBiggestNumber(54998));
    }

    @Test
    public void test22437() {
        Assert.assertEquals(22473, NextBiggestNumber.getNextBiggestNumber(22437));
    }

    @Test
    public void test53510() {
        Assert.assertEquals(55013, NextBiggestNumber.getNextBiggestNumber(53510));
    }

    @Test
    public void test78263() {
        Assert.assertEquals(78326, NextBiggestNumber.getNextBiggestNumber(78263));
    }

    @Test
    public void test42661() {
        Assert.assertEquals(46126, NextBiggestNumber.getNextBiggestNumber(42661));
    }

    @Test
    public void test45118() {
        Assert.assertEquals(45181, NextBiggestNumber.getNextBiggestNumber(45118));
    }

    @Test
    public void test26075() {
        Assert.assertEquals(26507, NextBiggestNumber.getNextBiggestNumber(26075));
    }

    @Test
    public void test93932() {
        Assert.assertEquals(99233, NextBiggestNumber.getNextBiggestNumber(93932));
    }

    @Test
    public void test84252() {
        Assert.assertEquals(84522, NextBiggestNumber.getNextBiggestNumber(84252));
    }

    @Test
    public void test33203() {
        Assert.assertEquals(33230, NextBiggestNumber.getNextBiggestNumber(33203));
    }

    @Test
    public void test98037() {
        Assert.assertEquals(98073, NextBiggestNumber.getNextBiggestNumber(98037));
    }

    @Test
    public void test74041() {
        Assert.assertEquals(74104, NextBiggestNumber.getNextBiggestNumber(74041));
    }

    @Test
    public void test11856() {
        Assert.assertEquals(11865, NextBiggestNumber.getNextBiggestNumber(11856));
    }

    @Test
    public void test47998() {
        Assert.assertEquals(48799, NextBiggestNumber.getNextBiggestNumber(47998));
    }

    @Test
    public void test36708() {
        Assert.assertEquals(36780, NextBiggestNumber.getNextBiggestNumber(36708));
    }

    @Test
    public void test93802() {
        Assert.assertEquals(93820, NextBiggestNumber.getNextBiggestNumber(93802));
    }

    @Test
    public void test2902() {
        Assert.assertEquals(2920, NextBiggestNumber.getNextBiggestNumber(2902));
    }

    @Test
    public void test71116() {
        Assert.assertEquals(71161, NextBiggestNumber.getNextBiggestNumber(71116));
    }

    @Test
    public void test76532() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(76532));
    }

    @Test
    public void test81848() {
        Assert.assertEquals(81884, NextBiggestNumber.getNextBiggestNumber(81848));
    }

    @Test
    public void test93493() {
        Assert.assertEquals(93934, NextBiggestNumber.getNextBiggestNumber(93493));
    }

    @Test
    public void test16332() {
        Assert.assertEquals(21336, NextBiggestNumber.getNextBiggestNumber(16332));
    }

    @Test
    public void test97939() {
        Assert.assertEquals(97993, NextBiggestNumber.getNextBiggestNumber(97939));
    }

    @Test
    public void test4386() {
        Assert.assertEquals(4638, NextBiggestNumber.getNextBiggestNumber(4386));
    }

    @Test
    public void test6950() {
        Assert.assertEquals(9056, NextBiggestNumber.getNextBiggestNumber(6950));
    }

    @Test
    public void test92232() {
        Assert.assertEquals(92322, NextBiggestNumber.getNextBiggestNumber(92232));
    }

    @Test
    public void test39527() {
        Assert.assertEquals(39572, NextBiggestNumber.getNextBiggestNumber(39527));
    }

    @Test
    public void test41766() {
        Assert.assertEquals(46167, NextBiggestNumber.getNextBiggestNumber(41766));
    }

    @Test
    public void test3399() {
        Assert.assertEquals(3939, NextBiggestNumber.getNextBiggestNumber(3399));
    }

    @Test
    public void test77957() {
        Assert.assertEquals(77975, NextBiggestNumber.getNextBiggestNumber(77957));
    }

    @Test
    public void test81899() {
        Assert.assertEquals(81989, NextBiggestNumber.getNextBiggestNumber(81899));
    }

    @Test
    public void test2403() {
        Assert.assertEquals(2430, NextBiggestNumber.getNextBiggestNumber(2403));
    }

    @Test
    public void test23817() {
        Assert.assertEquals(23871, NextBiggestNumber.getNextBiggestNumber(23817));
    }

    @Test
    public void test85520() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(85520));
    }

    @Test
    public void test42882() {
        Assert.assertEquals(48228, NextBiggestNumber.getNextBiggestNumber(42882));
    }

    @Test
    public void test56072() {
        Assert.assertEquals(56207, NextBiggestNumber.getNextBiggestNumber(56072));
    }

    @Test
    public void test89101() {
        Assert.assertEquals(89110, NextBiggestNumber.getNextBiggestNumber(89101));
    }

    @Test
    public void test25384() {
        Assert.assertEquals(25438, NextBiggestNumber.getNextBiggestNumber(25384));
    }

    @Test
    public void test54443() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(54443));
    }

    @Test
    public void test49459() {
        Assert.assertEquals(49495, NextBiggestNumber.getNextBiggestNumber(49459));
    }

    @Test
    public void test84803() {
        Assert.assertEquals(84830, NextBiggestNumber.getNextBiggestNumber(84803));
    }

    @Test
    public void test50766() {
        Assert.assertEquals(56067, NextBiggestNumber.getNextBiggestNumber(50766));
    }

    @Test
    public void test43770() {
        Assert.assertEquals(47037, NextBiggestNumber.getNextBiggestNumber(43770));
    }

    @Test
    public void test33285() {
        Assert.assertEquals(33528, NextBiggestNumber.getNextBiggestNumber(33285));
    }

    @Test
    public void test42083() {
        Assert.assertEquals(42308, NextBiggestNumber.getNextBiggestNumber(42083));
    }

    @Test
    public void test47482() {
        Assert.assertEquals(47824, NextBiggestNumber.getNextBiggestNumber(47482));
    }

    @Test
    public void test45634() {
        Assert.assertEquals(45643, NextBiggestNumber.getNextBiggestNumber(45634));
    }

    @Test
    public void test73784() {
        Assert.assertEquals(73847, NextBiggestNumber.getNextBiggestNumber(73784));
    }

    @Test
    public void test97071() {
        Assert.assertEquals(97107, NextBiggestNumber.getNextBiggestNumber(97071));
    }

    @Test
    public void test81003() {
        Assert.assertEquals(81030, NextBiggestNumber.getNextBiggestNumber(81003));
    }

    @Test
    public void test32619() {
        Assert.assertEquals(32691, NextBiggestNumber.getNextBiggestNumber(32619));
    }

    @Test
    public void test36448() {
        Assert.assertEquals(36484, NextBiggestNumber.getNextBiggestNumber(36448));
    }

    @Test
    public void test22368() {
        Assert.assertEquals(22386, NextBiggestNumber.getNextBiggestNumber(22368));
    }

    @Test
    public void test22794() {
        Assert.assertEquals(22947, NextBiggestNumber.getNextBiggestNumber(22794));
    }

    @Test
    public void test58927() {
        Assert.assertEquals(58972, NextBiggestNumber.getNextBiggestNumber(58927));
    }

    @Test
    public void test73399() {
        Assert.assertEquals(73939, NextBiggestNumber.getNextBiggestNumber(73399));
    }

    @Test
    public void test81830() {
        Assert.assertEquals(83018, NextBiggestNumber.getNextBiggestNumber(81830));
    }

    @Test
    public void test49685() {
        Assert.assertEquals(49856, NextBiggestNumber.getNextBiggestNumber(49685));
    }

    @Test
    public void test73251() {
        Assert.assertEquals(73512, NextBiggestNumber.getNextBiggestNumber(73251));
    }

    @Test
    public void test44595() {
        Assert.assertEquals(44955, NextBiggestNumber.getNextBiggestNumber(44595));
    }

    @Test
    public void test81165() {
        Assert.assertEquals(81516, NextBiggestNumber.getNextBiggestNumber(81165));
    }

    @Test
    public void test85034() {
        Assert.assertEquals(85043, NextBiggestNumber.getNextBiggestNumber(85034));
    }

    @Test
    public void test31814() {
        Assert.assertEquals(31841, NextBiggestNumber.getNextBiggestNumber(31814));
    }

    @Test
    public void test79768() {
        Assert.assertEquals(79786, NextBiggestNumber.getNextBiggestNumber(79768));
    }

    @Test
    public void test88439() {
        Assert.assertEquals(88493, NextBiggestNumber.getNextBiggestNumber(88439));
    }

    @Test
    public void test44697() {
        Assert.assertEquals(44769, NextBiggestNumber.getNextBiggestNumber(44697));
    }

    @Test
    public void test52821() {
        Assert.assertEquals(58122, NextBiggestNumber.getNextBiggestNumber(52821));
    }

    @Test
    public void test80263() {
        Assert.assertEquals(80326, NextBiggestNumber.getNextBiggestNumber(80263));
    }

    @Test
    public void test71049() {
        Assert.assertEquals(71094, NextBiggestNumber.getNextBiggestNumber(71049));
    }

    @Test
    public void test91362() {
        Assert.assertEquals(91623, NextBiggestNumber.getNextBiggestNumber(91362));
    }

    @Test
    public void test17056() {
        Assert.assertEquals(17065, NextBiggestNumber.getNextBiggestNumber(17056));
    }

    @Test
    public void test26130() {
        Assert.assertEquals(26301, NextBiggestNumber.getNextBiggestNumber(26130));
    }

    @Test
    public void test83800() {
        Assert.assertEquals(88003, NextBiggestNumber.getNextBiggestNumber(83800));
    }

    @Test
    public void test52246() {
        Assert.assertEquals(52264, NextBiggestNumber.getNextBiggestNumber(52246));
    }

    @Test
    public void test56996() {
        Assert.assertEquals(59669, NextBiggestNumber.getNextBiggestNumber(56996));
    }

    @Test
    public void test30281() {
        Assert.assertEquals(30812, NextBiggestNumber.getNextBiggestNumber(30281));
    }

    @Test
    public void test51428() {
        Assert.assertEquals(51482, NextBiggestNumber.getNextBiggestNumber(51428));
    }

    @Test
    public void test7654() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(7654));
    }

    @Test
    public void test33095() {
        Assert.assertEquals(33509, NextBiggestNumber.getNextBiggestNumber(33095));
    }

    @Test
    public void test50933() {
        Assert.assertEquals(53039, NextBiggestNumber.getNextBiggestNumber(50933));
    }

    @Test
    public void test7558() {
        Assert.assertEquals(7585, NextBiggestNumber.getNextBiggestNumber(7558));
    }

    @Test
    public void test75659() {
        Assert.assertEquals(75695, NextBiggestNumber.getNextBiggestNumber(75659));
    }

    @Test
    public void test36639() {
        Assert.assertEquals(36693, NextBiggestNumber.getNextBiggestNumber(36639));
    }

    @Test
    public void test75517() {
        Assert.assertEquals(75571, NextBiggestNumber.getNextBiggestNumber(75517));
    }

    @Test
    public void test64149() {
        Assert.assertEquals(64194, NextBiggestNumber.getNextBiggestNumber(64149));
    }

    @Test
    public void test44926() {
        Assert.assertEquals(44962, NextBiggestNumber.getNextBiggestNumber(44926));
    }

    @Test
    public void test16230() {
        Assert.assertEquals(16302, NextBiggestNumber.getNextBiggestNumber(16230));
    }

    @Test
    public void test36166() {
        Assert.assertEquals(36616, NextBiggestNumber.getNextBiggestNumber(36166));
    }

    @Test
    public void test14134() {
        Assert.assertEquals(14143, NextBiggestNumber.getNextBiggestNumber(14134));
    }

    @Test
    public void test66848() {
        Assert.assertEquals(66884, NextBiggestNumber.getNextBiggestNumber(66848));
    }

    @Test
    public void test85420() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(85420));
    }

    @Test
    public void test6447() {
        Assert.assertEquals(6474, NextBiggestNumber.getNextBiggestNumber(6447));
    }

    @Test
    public void test70690() {
        Assert.assertEquals(70906, NextBiggestNumber.getNextBiggestNumber(70690));
    }

    @Test
    public void test55511() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(55511));
    }

    @Test
    public void test55224() {
        Assert.assertEquals(55242, NextBiggestNumber.getNextBiggestNumber(55224));
    }

    @Test
    public void test73239() {
        Assert.assertEquals(73293, NextBiggestNumber.getNextBiggestNumber(73239));
    }

    @Test
    public void test21166() {
        Assert.assertEquals(21616, NextBiggestNumber.getNextBiggestNumber(21166));
    }

    @Test
    public void test69958() {
        Assert.assertEquals(69985, NextBiggestNumber.getNextBiggestNumber(69958));
    }

    @Test
    public void test59609() {
        Assert.assertEquals(59690, NextBiggestNumber.getNextBiggestNumber(59609));
    }

    @Test
    public void test28850() {
        Assert.assertEquals(50288, NextBiggestNumber.getNextBiggestNumber(28850));
    }

    @Test
    public void test34085() {
        Assert.assertEquals(34508, NextBiggestNumber.getNextBiggestNumber(34085));
    }

    @Test
    public void test68686() {
        Assert.assertEquals(68866, NextBiggestNumber.getNextBiggestNumber(68686));
    }

    @Test
    public void test30015() {
        Assert.assertEquals(30051, NextBiggestNumber.getNextBiggestNumber(30015));
    }

    @Test
    public void test95116() {
        Assert.assertEquals(95161, NextBiggestNumber.getNextBiggestNumber(95116));
    }

    @Test
    public void test68150() {
        Assert.assertEquals(68501, NextBiggestNumber.getNextBiggestNumber(68150));
    }

    @Test
    public void test80403() {
        Assert.assertEquals(80430, NextBiggestNumber.getNextBiggestNumber(80403));
    }

    @Test
    public void test32154() {
        Assert.assertEquals(32415, NextBiggestNumber.getNextBiggestNumber(32154));
    }

    @Test
    public void test34731() {
        Assert.assertEquals(37134, NextBiggestNumber.getNextBiggestNumber(34731));
    }

    @Test
    public void test18099() {
        Assert.assertEquals(18909, NextBiggestNumber.getNextBiggestNumber(18099));
    }

    @Test
    public void test13447() {
        Assert.assertEquals(13474, NextBiggestNumber.getNextBiggestNumber(13447));
    }

    @Test
    public void test56296() {
        Assert.assertEquals(56629, NextBiggestNumber.getNextBiggestNumber(56296));
    }

    @Test
    public void test1276() {
        Assert.assertEquals(1627, NextBiggestNumber.getNextBiggestNumber(1276));
    }

    @Test
    public void test44944() {
        Assert.assertEquals(49444, NextBiggestNumber.getNextBiggestNumber(44944));
    }

    @Test
    public void test75519() {
        Assert.assertEquals(75591, NextBiggestNumber.getNextBiggestNumber(75519));
    }

    @Test
    public void test45632() {
        Assert.assertEquals(46235, NextBiggestNumber.getNextBiggestNumber(45632));
    }

    @Test
    public void test27590() {
        Assert.assertEquals(27905, NextBiggestNumber.getNextBiggestNumber(27590));
    }

    @Test
    public void test7251() {
        Assert.assertEquals(7512, NextBiggestNumber.getNextBiggestNumber(7251));
    }

    @Test
    public void test90251() {
        Assert.assertEquals(90512, NextBiggestNumber.getNextBiggestNumber(90251));
    }

    @Test
    public void test98728() {
        Assert.assertEquals(98782, NextBiggestNumber.getNextBiggestNumber(98728));
    }

    @Test
    public void test51811() {
        Assert.assertEquals(58111, NextBiggestNumber.getNextBiggestNumber(51811));
    }

    @Test
    public void test59358() {
        Assert.assertEquals(59385, NextBiggestNumber.getNextBiggestNumber(59358));
    }

    @Test
    public void test24098() {
        Assert.assertEquals(24809, NextBiggestNumber.getNextBiggestNumber(24098));
    }

    @Test
    public void test59176() {
        Assert.assertEquals(59617, NextBiggestNumber.getNextBiggestNumber(59176));
    }

    @Test
    public void test54917() {
        Assert.assertEquals(54971, NextBiggestNumber.getNextBiggestNumber(54917));
    }

    @Test
    public void test8165() {
        Assert.assertEquals(8516, NextBiggestNumber.getNextBiggestNumber(8165));
    }

    @Test
    public void test34178() {
        Assert.assertEquals(34187, NextBiggestNumber.getNextBiggestNumber(34178));
    }

    @Test
    public void test71652() {
        Assert.assertEquals(72156, NextBiggestNumber.getNextBiggestNumber(71652));
    }

    @Test
    public void test26168() {
        Assert.assertEquals(26186, NextBiggestNumber.getNextBiggestNumber(26168));
    }

    @Test
    public void test49396() {
        Assert.assertEquals(49639, NextBiggestNumber.getNextBiggestNumber(49396));
    }

    @Test
    public void test78946() {
        Assert.assertEquals(78964, NextBiggestNumber.getNextBiggestNumber(78946));
    }

    @Test
    public void test33316() {
        Assert.assertEquals(33361, NextBiggestNumber.getNextBiggestNumber(33316));
    }

    @Test
    public void test15484() {
        Assert.assertEquals(15844, NextBiggestNumber.getNextBiggestNumber(15484));
    }

    @Test
    public void test2211() {
        Assert.assertEquals(-1, NextBiggestNumber.getNextBiggestNumber(2211));
    }

    @Test
    public void test97203() {
        Assert.assertEquals(97230, NextBiggestNumber.getNextBiggestNumber(97203));
    }

    @Test
    public void test70956() {
        Assert.assertEquals(70965, NextBiggestNumber.getNextBiggestNumber(70956));
    }

}
