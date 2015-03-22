package com.appbootup.gwt.client;

import com.amcharts.impl.wrapper.IsReadyCallback;
import com.appbootup.gwt.client.line.LineChartWithScrollAndZoom;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTAMChart implements EntryPoint
{
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// GWTAMChartSample.pieChartByJSNI();
		// GWTAMChartSample.serialChartByJSNI();
		// GWTAMChartSample.chartByServerJSON();
		// GWTAMChartSample.lineWithTrendLineChartByJSNI();
		// final SimplePieChart chartWrapper = new SimplePieChart();
		// final ThreeDPieChart chartWrapper = new ThreeDPieChart();
		// final DonutChart chartWrapper = new DonutChart();
		// final ThreeDDonutChart chartWrapper = new ThreeDDonutChart();
		// final PieChartWithLegend chartWrapper = new PieChartWithLegend();
		// final PieChartBrokenSlices chartWrapper = new PieChartBrokenSlices();
		// final PyramidChart chartWrapper = new PyramidChart();
		// final ThreeDFunnelChart chartWrapper = new ThreeDFunnelChart();
		// final FunnelChart chartWrapper = new FunnelChart();
		// final ColumnWithRotatedSeries chartWrapper = new ColumnWithRotatedSeries();
		// final SimpleColumnChart chartWrapper = new SimpleColumnChart();
		// final ColumnChartWithEvents chartWrapper = new ColumnChartWithEvents();
		// final StackedColumnChart chartWrapper = new StackedColumnChart();
		// final ThreeDCylinderChart chartWrapper = new ThreeDCylinderChart();
		// final LineDifferentColorsUpsDowns chartWrapper = new LineDifferentColorsUpsDowns();
		// final DateBasedData chartWrapper = new DateBasedData();
		// final MultipleValueAxes chartWrapper = new MultipleValueAxes();
		// final BubbleChart chartWrapper = new BubbleChart();
		// final PolarChart chartWrapper = new PolarChart();
		// final MicroChartsSparklines chartWrapper = new MicroChartsSparklines();
		// final AngularGaugeWithTwoAxes chartWrapper = new AngularGaugeWithTwoAxes();
		// final AngularGauge chartWrapper = new AngularGauge();
		// final ExportingChartToImage chartWrapper = new ExportingChartToImage();
		// final LineWithChangingColor chartWrapper = new LineWithChangingColor();
		// final StackedArea chartWrapper = new StackedArea();
		// final DurationOnValueAxis chartWrapper = new DurationOnValueAxis();
		// final UpdatingBalloonTooltip chartWrapper = new UpdatingBalloonTooltip();
		// final MultiDimensionalDrilldownBackButton chartWrapper = new MultiDimensionalDrilldownBackButton();
		// final LinkingPieChartColumnChartDrillDataDisplay chartWrapper = new LinkingPieChartColumnChartDrillDataDisplay();
		final LineChartWithScrollAndZoom chartWrapper = new LineChartWithScrollAndZoom();
		chartWrapper.setReadyCallback( new IsReadyCallback()
		{
			public void onReady()
			{
				chartWrapper.setSize( "750px", "400px" );
				Widget widget = chartWrapper.getChartWidget();
				widget.setSize( "750px", "400px" );
				RootLayoutPanel.get().add( widget );
			}
		} );
		chartWrapper.init();
	}
}