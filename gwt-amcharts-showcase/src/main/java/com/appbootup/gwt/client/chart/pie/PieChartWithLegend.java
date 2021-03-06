package com.appbootup.gwt.client.chart.pie;

import com.amcharts.impl.AmCharts;
import com.amcharts.impl.AmLegend;
import com.amcharts.impl.AmPieChart;
import com.amcharts.impl.ExportConfig;
import com.amcharts.impl.MenuItem;
import com.amcharts.impl.wrapper.AbstractChartWrapper;
import com.appbootup.gwt.client.ChartServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PieChartWithLegend extends AbstractChartWrapper
{
	public PieChartWithLegend()
	{
		ChartServiceAsync.Util.getInstance()
				.getData( "/data/pieChartWithLegend.json", new AsyncCallback<String>()
				{
					@Override
					public void onSuccess( String chartData )
					{
						JsArray<JavaScriptObject> dataProvider = JsonUtils
								.unsafeEval( chartData );
						drawChart( dataProvider );
					}

					@Override
					public void onFailure( Throwable caught )
					{
						GWT.log( "This Sucks", caught );
					}
				} );
	}

	protected void drawChart( JsArray<JavaScriptObject> chartData )
	{
		AmPieChart amPieChart = new AmPieChart();
		amPieChart.setDataProvider( chartData );
		amPieChart.setTheme( "none" );
		AmLegend legend = new AmLegend();
		legend.setMarkerType( "circle" );
		legend.setPosition( "right" );
		legend.setMarginRight( 80 );
		legend.setAutoMargins( false );
		amPieChart.setLegend( legend );
		amPieChart.setValueField( "litres" );
		amPieChart.setTitleField( "country" );
		amPieChart
				.setBalloonText( "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>" );
		ExportConfig exportConfig = new ExportConfig();
		MenuItem menuItem = new MenuItem();
		menuItem.setIcon( AmCharts.JS_AMCHARTS_IMAGES + "export.png" );
		menuItem.setFormat( "png" );
		exportConfig.addMenuItem( menuItem );
		exportConfig.setMenuTop( "0px" );
		amPieChart.setExportConfig( exportConfig );

		setAmChart( amPieChart );
		getReadyCallback().onReady();
	}
}